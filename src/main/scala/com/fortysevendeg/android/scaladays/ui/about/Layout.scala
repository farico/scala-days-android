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

package com.fortysevendeg.android.scaladays.ui.about

import android.content.Intent
import android.net.Uri
import android.widget._
import com.fortysevendeg.android.scaladays.R
import com.fortysevendeg.android.scaladays.ui.commons.PlaceHolderLayout
import macroid.FullDsl._
import macroid.{Ui, ActivityContext, AppContext}

class Layout(implicit appContext: AppContext, context: ActivityContext)
    extends Styles
    with PlaceHolderLayout {

  var description = slot[TextView]

  var mainContent = slot[LinearLayout]

  var placeholderContent = slot[LinearLayout]

  var aboutContent = slot[LinearLayout]

  val content = getUi(
    l[FrameLayout](
      l[LinearLayout](
        l[ScrollView](
          l[LinearLayout](
            w[TextView] <~ titleStyle,
            w[TextView] <~ wire(description) <~ descriptionStyle
          ) <~ contentStyle
        ) <~ scrollStyle,
        l[LinearLayout](
          w[ImageView] <~ about47ImageStyle,
          w[TextView] <~ about47TextStyle
        ) <~ about47ContentStyle <~ wire(aboutContent)
      ) <~ wire(mainContent) <~ rootStyle,
      placeholder <~ wire(placeholderContent)
    )
  )

  def layout = content

}