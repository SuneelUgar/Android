package com.ugar.powermockito;

import android.os.Build;
import android.support.constraint.BuildConfig;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "AndroidManifest.xml", constants = BuildConfig.class, sdk = Build.VERSION_CODES.O)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest(MyStaticUtility.class)

public class PowerMockExampleTest {


    @Rule
    public PowerMockRule rule = new PowerMockRule();

    private MainActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MainActivity.class).create().resume().get();
    }

    @Test
    public void testActivity() {
        assertNotNull(activity);

    }

    @Test
    public void testPowerMockWithRobolectric() {
        PowerMockito.mockStatic(MyStaticUtility.class);
        Mockito.when(MyStaticUtility.getString()).thenReturn("Hello Power Mockito");
        assertNotNull(MyStaticUtility.getString());

    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}