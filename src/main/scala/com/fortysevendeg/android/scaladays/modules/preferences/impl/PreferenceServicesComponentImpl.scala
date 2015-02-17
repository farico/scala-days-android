/*
 * Copyright (C) 2015 47 Degrees, LLC http://47deg.com hello@47deg.com
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may
 *  not use this file except in compliance with the License. You may obtain
 *  a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.fortysevendeg.android.scaladays.modules.preferences.impl

import android.content.Context
import com.fortysevendeg.android.scaladays.modules.preferences._
import com.fortysevendeg.macroid.extras.AppContextProvider

trait PreferenceServicesComponentImpl
    extends PreferenceServicesComponent {

  self: AppContextProvider =>

  val preferenceServices = new PreferenceServicesImpl
  
  val preferencesName = "applicationPreferences"

  class PreferenceServicesImpl
      extends PreferenceServices {
    
    lazy val sharedPreferences = appContextProvider.get.getSharedPreferences(preferencesName, Context.MODE_PRIVATE)

    def fetchIntPreference(request: PreferenceRequest[Int]): PreferenceResponse[Int] =
        PreferenceResponse(sharedPreferences.getInt(request.name, request.value))

    def saveIntPreference(request: PreferenceRequest[Int]): PreferenceResponse[Int] = {
        sharedPreferences.edit().putInt(request.name, request.value).apply()
        PreferenceResponse(request.value)
      }

    def fetchBooleanPreference(request: PreferenceRequest[Boolean]): PreferenceResponse[Boolean] =
      PreferenceResponse(sharedPreferences.getBoolean(request.name, request.value))

    def saveBooleanPreference(request: PreferenceRequest[Boolean]): PreferenceResponse[Boolean] = {
      sharedPreferences.edit().putBoolean(request.name, request.value).apply()
      PreferenceResponse(request.value)
    }

  }

}
