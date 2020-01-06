/*
 * Copyright 2020 HM Revenue & Customs
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

package models

case class Name(name: String = "")

object Name {
  implicit def string2Name(name: Option[String]): Option[Name] = name.map(op => Name(op))
}

case class PhoneNumber(phoneNumber: String = "")

object PhoneNumber {
  implicit def string2PhoneNumber(phone: Option[String]): Option[PhoneNumber] = phone.map(op => PhoneNumber(op))
}

case class CanWeWrite(contact: Boolean = false)

object CanWeWrite {
  implicit def boolean2CanWeWrite(canWeWrite: Option[Boolean]): Option[CanWeWrite] = canWeWrite.map(op => CanWeWrite(op))
}

case class Address(lines: String = "")

object Address {
  implicit def string2Address(address: Option[String]): Option[Address] = address.map(op => Address(op))
}

case class PersonalDetails(
                            name: Option[Name] = None,
                            phone: Option[PhoneNumber] = None,
                            canWeWrite: Option[CanWeWrite] = None,
                            address: Option[Address] = None
                          )




