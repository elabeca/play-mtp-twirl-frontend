//Google Tag Manager

(function (w, d, s, l, i) {
    w[l] = w[l] || [];
    w[l].push({'gtm.start': new Date().getTime(), event: 'gtm.js'});
    var f = d.getElementsByTagName(s)[0], j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : '';
    j.async = true;
    j.src = 'https://www.googletagmanager.com/gtm.js?id=' + i + dl;
    f.parentNode.insertBefore(j, f);
})(window, document, 'script', 'dataLayer', 'GTM-TGKSS46');

// End Google Tag Manager

(function () {
    var key = 'hmrc-tracking-preferences'
    var hiddenClass = 'hmrc-cookie-preference-display--hidden'
    var version = '2020-01-01'
    var prefElem = document.getElementById('hmrc-cookie-preference-display')
    if (!window.localStorage) {
        return
    }

    function getPref() {
        var str = localStorage.getItem(key)
        if (!str) {
            return null
        }
        var obj = JSON.parse(str)
        if (obj.version !== version) {
            throw new Error('Unknown version: ' + obj.version)
        }
        return obj.preferences
    }

    function setPref(preferences) {
        localStorage.setItem(key, JSON.stringify({
            version: version,
            preferences: {...preferences, date: new Date().getTime()}
        }))
    }

    function hasSetPref() {
        return getPref() !== null
    }

    function updatePref() {
        var preferences = getPref()
        console.log('read preferences', preferences)
        if (preferences.tracking) {
            dataLayer.push({event: 'hmrc-tracking-allowed'})
        }
        if (preferences.communication) {
            dataLayer.push({event: 'hmrc-communication-allowed'})
        }
        if (preferences.measurement) {
            dataLayer.push({event: 'hmrc-measurement-allowed'})
        }
    }

    function addHandlerForButton(selector, preferences) {
        prefElem.querySelector(selector).addEventListener('click', function (e) {
            prefElem.classList.add(hiddenClass)
            setPref(preferences)
            updatePref()
        })
    }

    if (hasSetPref()) {
        updatePref()
    } else {
        console.log('no preferences set')
        if (!prefElem) {
            console.log('no preferences element')
            throw new Error('No preference pane available')
        }
        prefElem.classList.remove(hiddenClass)
        addHandlerForButton('.acceptAll', {
            acceptedAll: true,
            tracking: true,
            communication: true,
            measurement: true
        });
        addHandlerForButton('.acceptCommunication', {
            acceptedAll: false,
            tracking: false,
            communication: true,
            measurement: false
        });
        addHandlerForButton('.acceptTracking', {
            acceptedAll: false,
            tracking: true,
            communication: false,
            measurement: false
        });
    }

}())
