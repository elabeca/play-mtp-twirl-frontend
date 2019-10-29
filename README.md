
# Personal Details Account using [Twirl](https://github.com/hmrc/play-frontend-govuk) library

### Getting started
1>  Add [Twirl](https://github.com/hmrc/play-frontend-govuk/releases) library in the App dependencies. Please use the latest available version and report any issues in #event-play-frontend-beta
```scala
"uk.gov.hmrc"       %% "play-frontend-govuk"            % "x.y.z-play-26"
```

2>  Add SASS assets to app/assets/stylesheets in application.scss to inherit / extend GovUk style assets / elements
```
$govuk-assets-path: "/play-mtp-twirl-frontend/assets/lib/govuk-frontend/govuk/assets/";

@import "lib/govuk-frontend/govuk/all";

.app-reference-number {
  display: block;
  font-weight: bold;
}
```

3>  Add govuk-frontend routing redirection in app.routes:
```scala
->         /govuk-frontend                      govuk.Routes
```

4>  Add TwirlKeys.templateImports in build.sbt:
```sbt
    TwirlKeys.templateImports ++= Seq(
      "uk.gov.hmrc.govukfrontend.views.html.components._",
      "uk.gov.hmrc.govukfrontend.views.html.helpers._"
    )
```

5>  Use GovukLayout from library to create standard views out of the box
```scala
@govukLayout(
    pageTitle = pageTitle,
    headBlock = Some(head()),
    beforeContentBlock = beforeContentBlock,
    footerItems = Seq(FooterItem(href = Some("https://govuk-prototype-kit.herokuapp.com/"), text = Some("GOV.UK Prototype Kit v9.1.0"))),
    bodyEndBlock = Some(scripts()))(contentBlock)
```

6>  See more tips [here](https://github.com/hmrc/play-frontend-govuk#getting-started)

 
   