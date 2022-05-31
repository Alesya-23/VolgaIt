package com.laba.volgait.ui.base

import androidx.lifecycle.ViewModel
import com.laba.volgait.error.ErrorManager

abstract class BaseViewModel : ViewModel() {
    lateinit var errorManager: ErrorManager
}