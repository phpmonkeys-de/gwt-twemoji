/**
 * MIT License
 *
 * Copyright (c) 2018 PhpMonkeys.de
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
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
