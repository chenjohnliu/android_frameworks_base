/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settingslib;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import android.content.Context;
import android.system.StructUtsname;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

@RunWith(RobolectricTestRunner.class)
public class DeviceInfoUtilsTest {

    private Context mContext;

    @Before
    public void setup() {
        mContext = RuntimeEnvironment.application;
    }

    @Test
    public void formatKernelVersion_regularInputVersion_shouldStripOptionalValues() {
        final String sysName = "Linux";
        final String nodeName = "localhost";
        final String release = "4.4.88-g134be430baab";
        final String version = "#1 SMP PREEMPT Tue Dec 31 12:00:00 UTC 2017";
        final String machine = "aarch64";
        final StructUtsname uname = new StructUtsname(sysName, nodeName, release, version, machine);

        final String expected = release + "\n" + "#1 Tue Dec 31 12:00:00 UTC 2017";

        assertThat(DeviceInfoUtils.formatKernelVersion(mContext, uname)).isEqualTo(expected);
    }

    @Test
    public void formatKernelVersion_nonRegularInputVersion_shouldBeUnavailable() {
        final String sysName = "Linux";
        final String nodeName = "localhost";
        final String release = "4.4.88-g134be430baab";
        final String version = "%@%!asd%#@!$" + "\n " + "fasdfasdfa13ta";
        final String machine = "aarch64";
        final StructUtsname uname = new StructUtsname(sysName, nodeName, release, version, machine);

        final String expected = mContext.getString(R.string.status_unavailable);

        assertThat(DeviceInfoUtils.formatKernelVersion(mContext, uname)).isEqualTo(expected);
    }

    @Test
    public void formatKernelVersion_nullInputVersion_shouldBeUnavailable() {
        final String expected = mContext.getString(R.string.status_unavailable);

        assertThat(DeviceInfoUtils.formatKernelVersion(mContext, null)).isEqualTo(expected);
    }

    @Test
    public void getPhoneNumber_imsOnlyNumber_usesStandardSubscriptionApi() {
        SubscriptionManager subscriptions = mock(SubscriptionManager.class);
        TelephonyManager telephony = mock(TelephonyManager.class);
        when(subscriptions.getPhoneNumber(1)).thenReturn("+15555550123");

        assertThat(DeviceInfoUtils.getPhoneNumber(subscriptions, telephony, 1))
                .isEqualTo("+15555550123");
        verifyNoInteractions(telephony);
    }

    @Test
    public void getPhoneNumber_emptyModernNumber_fallsBackToSameSubscription() {
        SubscriptionManager subscriptions = mock(SubscriptionManager.class);
        TelephonyManager telephony = mock(TelephonyManager.class);
        TelephonyManager selected = mock(TelephonyManager.class);
        when(subscriptions.getPhoneNumber(7)).thenReturn("");
        when(telephony.createForSubscriptionId(7)).thenReturn(selected);
        when(selected.getLine1Number()).thenReturn("+15555550124");

        assertThat(DeviceInfoUtils.getPhoneNumber(subscriptions, telephony, 7))
                .isEqualTo("+15555550124");
        verify(telephony).createForSubscriptionId(7);
    }

    @Test
    public void getPhoneNumber_modernPermissionDenied_usesLegacyNumber() {
        SubscriptionManager subscriptions = mock(SubscriptionManager.class);
        TelephonyManager telephony = mock(TelephonyManager.class);
        when(subscriptions.getPhoneNumber(1)).thenThrow(new SecurityException());
        when(telephony.createForSubscriptionId(1)).thenReturn(telephony);
        when(telephony.getLine1Number()).thenReturn("+15555550123");

        assertThat(DeviceInfoUtils.getPhoneNumber(subscriptions, telephony, 1))
                .isEqualTo("+15555550123");
    }

    @Test
    public void getPhoneNumber_modernServiceUnavailable_usesLegacyNumber() {
        SubscriptionManager subscriptions = mock(SubscriptionManager.class);
        TelephonyManager telephony = mock(TelephonyManager.class);
        when(subscriptions.getPhoneNumber(1)).thenThrow(new IllegalStateException());
        when(telephony.createForSubscriptionId(1)).thenReturn(telephony);
        when(telephony.getLine1Number()).thenReturn("+15555550123");

        assertThat(DeviceInfoUtils.getPhoneNumber(subscriptions, telephony, 1))
                .isEqualTo("+15555550123");
    }

    @Test
    public void getPhoneNumber_invalidSubscription_doesNotReadDefaultSim() {
        SubscriptionManager subscriptions = mock(SubscriptionManager.class);
        TelephonyManager telephony = mock(TelephonyManager.class);

        assertThat(DeviceInfoUtils.getPhoneNumber(subscriptions, telephony,
                SubscriptionManager.INVALID_SUBSCRIPTION_ID)).isNull();
        verifyNoInteractions(subscriptions, telephony);
    }

    @Test
    public void getPhoneNumber_noServices_returnsNull() {
        assertThat(DeviceInfoUtils.getPhoneNumber(null, null, 1)).isNull();
    }

    @Test
    public void getPhoneNumber_defaultSubscription_doesNotReadOtherSim() {
        SubscriptionManager subscriptions = mock(SubscriptionManager.class);
        TelephonyManager telephony = mock(TelephonyManager.class);

        assertThat(DeviceInfoUtils.getPhoneNumber(subscriptions, telephony,
                SubscriptionManager.DEFAULT_SUBSCRIPTION_ID)).isNull();
        verifyNoInteractions(subscriptions, telephony);
    }

    @Test
    public void getPhoneNumber_noSubscriptionService_usesLegacyNumber() {
        TelephonyManager telephony = mock(TelephonyManager.class);
        when(telephony.createForSubscriptionId(1)).thenReturn(telephony);
        when(telephony.getLine1Number()).thenReturn("+15555550123");

        assertThat(DeviceInfoUtils.getPhoneNumber(null, telephony, 1))
                .isEqualTo("+15555550123");
    }

    @Test
    public void getPhoneNumber_bothSourcesUnavailable_returnsNull() {
        SubscriptionManager subscriptions = mock(SubscriptionManager.class);
        TelephonyManager telephony = mock(TelephonyManager.class);
        when(subscriptions.getPhoneNumber(1)).thenReturn("");
        when(telephony.createForSubscriptionId(1)).thenReturn(telephony);

        assertThat(DeviceInfoUtils.getPhoneNumber(subscriptions, telephony, 1)).isNull();
    }

    @Test
    public void getPhoneNumber_legacyPermissionDenied_returnsNull() {
        TelephonyManager telephony = mock(TelephonyManager.class);
        when(telephony.createForSubscriptionId(1)).thenReturn(telephony);
        when(telephony.getLine1Number()).thenThrow(new SecurityException());

        assertThat(DeviceInfoUtils.getPhoneNumber(null, telephony, 1)).isNull();
    }

    @Test
    public void getFormattedPhoneNumber_nullSubscription_returnsNull() {
        assertThat(DeviceInfoUtils.getFormattedPhoneNumber(mContext, null)).isNull();
    }
}
