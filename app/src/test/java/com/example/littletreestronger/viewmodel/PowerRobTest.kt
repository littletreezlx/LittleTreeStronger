package com.example.littletreestronger.viewmodel

import com.example.littletreestronger.BuildConfig
import org.powermock.core.classloader.annotations.PowerMockIgnore
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.powermock.modules.junit4.PowerMockRunner
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(PowerMockRunner::class)
@PowerMockRunnerDelegate(RobolectricTestRunner::class)
@Config(sdk = intArrayOf(21))
@PowerMockIgnore("org.mockito.*", "org.robolectric.*", "android.*")
abstract class PowerRobTest