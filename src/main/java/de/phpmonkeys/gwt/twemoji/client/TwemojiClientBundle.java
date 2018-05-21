package de.phpmonkeys.gwt.twemoji.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface TwemojiClientBundle extends ClientBundle {

    TwemojiClientBundle INSTANCE = GWT.create(TwemojiClientBundle.class);

    @Source("resources/twemoji.min.js")
    TextResource twemojiJs();
}
