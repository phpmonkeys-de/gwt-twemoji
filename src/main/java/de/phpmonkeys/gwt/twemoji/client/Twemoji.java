package de.phpmonkeys.gwt.twemoji.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;

public class Twemoji {

    private String baseUrl;

    public Twemoji() {
        baseUrl = GWT.getModuleBaseURL() + "twemoji/";
    }

    public void init() {
        injectScript();
        initNative(baseUrl);
    }

    private final native void initNative(String baseUrl)/*-{
        $wnd.twemoji.base = baseUrl;
    }-*/;

    public String parse(String htmlString) {
        return parseNative(htmlString);
    }

    private final native String parseNative(String htmlString)/*-{
        return $wnd.twemoji.parse(htmlString);
    }-*/;

    private void injectScript() {
        if (!isInjected()) {
            ScriptInjector.fromString(TwemojiClientBundle.INSTANCE.twemojiJs().getText()).setWindow(ScriptInjector.TOP_WINDOW).inject();
        }
    }

    private native final boolean isInjected() /*-{
      if (!(typeof $wnd.twemoji === "undefined") && !(null===$wnd.twemoji)) {
        return true;
      }
      return false;
    }-*/;
}
