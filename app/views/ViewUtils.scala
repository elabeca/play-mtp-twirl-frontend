/*
 * Copyright 2019 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package views

import controllers._
import models._
import play.api.i18n.Messages
import uk.gov.hmrc.govukfrontend.views.html.components._

object ViewUtils {

  private def mapNameToSummary(pda: PersonalDetails): SummaryListRow =
    SummaryListRow(
      key = Key(Text("Name")),
      value = Value(Text(s"${pda.name.getOrElse(Name()).name}")),
      actions = Some(
        Actions(
          items = Seq(ActionItem(href = s"${routes.NameController.onPageLoad(CheckMode).url}", content = Text("Change")))))
    )

  private def mapPhoneToSummary(pda: PersonalDetails): SummaryListRow =
    SummaryListRow(
      key = Key(Text("Phone number")),
      value = Value(Text(s"${pda.phone.getOrElse(PhoneNumber()).phoneNumber}")),
      actions = Some(
        Actions(
          items = Seq(ActionItem(href = s"${routes.PhoneNumberController.onPageLoad(CheckMode)}", content = Text("Change")))))
    )

  private def mapContactPrefToSummary(pda: PersonalDetails): SummaryListRow =
    SummaryListRow(
      key = Key(Text("Can we write to you?")),
      value = Value(Text(s"${pda.canWeWrite.getOrElse(CanWeWrite()).contact}")),
      actions = Some(Actions(
        items = Seq(ActionItem(href = s"${routes.ContactPreferenceController.onPageLoad(CheckMode)}", content = Text("Change")))))
    )

  private def mapAddressToSummary(address: Address): SummaryListRow =
    SummaryListRow(
      key = Key(Text("Address")),
      value = Value(Text(s"${address.lines}")),
      actions = Some(Actions(
        items = Seq(ActionItem(href = s"${routes.AddressController.onPageLoad(CheckMode)}", content = Text("Change")))))
    )

  def mapPersonalDetailsToSummary(details: PersonalDetails)(implicit messages: Messages): SummaryList = {
    SummaryList(Seq(mapNameToSummary(details), mapPhoneToSummary(details), mapContactPrefToSummary(details)) ++ (details.address map mapAddressToSummary))
  }
}
