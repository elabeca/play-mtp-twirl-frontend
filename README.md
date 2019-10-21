
# Personal Details Account using [Twirl](https://github.com/hmrc/play-frontend-govuk) library

## Getting started
1. A common layout view / template could be helpful. An example [Layout]((https://github.com/hmrc/play-mtp-frontend/blob/PLATUI-215/app/views/Layout.scala.html)) is being used here.
2. Here we use [head.scala.html](https://github.com/hmrc/play-mtp-frontend/blob/PLATUI-215/app/views/head.scala.html) and [script.scala.html](https://github.com/hmrc/play-mtp-frontend/blob/PLATUI-215/app/views/scripts.scala.html) for common styling / scripting elements.
3. Add [Twirl](https://github.com/hmrc/play-frontend-govuk) library in the App dependencies. Tested version: [play-frontend-govuk](https://github.com/hmrc/play-mtp-frontend/blob/PLATUI-215/project/AppDependencies.scala)
4. Add [scss](https://github.com/hmrc/play-mtp-frontend/tree/PLATUI-215/app/assets/stylesheets) assets.
5. Add govuk-frontend routing in [app.routes](https://github.com/hmrc/play-mtp-frontend/blob/PLATUI-215/conf/app.routes)
```scala
->         /govuk-frontend                      govuk.Routes
```
6. Add TwirlKeys.templateImports in [build.sbt](https://github.com/hmrc/play-mtp-frontend/blob/PLATUI-215/build.sbt)
```sbt
    TwirlKeys.templateImports ++= Seq(
      "uk.gov.hmrc.govukfrontend.views.html.components._",
      "uk.gov.hmrc.govukfrontend.views.html.helpers._"
    )
```
7. Use private library resolver:
```scala
resolvers += “hmrc-releases” at “https://artefacts.tax.service.gov.uk/artifactory/hmrc-releases/”
```
8. See more tips [here](https://github.com/hmrc/play-frontend-govuk#getting-started)


## Potential gotchas 
1. Haven't tested a way to get value back from session and set on forms when revisiting them
2. Haven't tested a way to get value back from session and set on summary page
