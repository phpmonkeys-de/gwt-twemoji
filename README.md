gwt-twemoji
===========

This project aims to wrap the Twitter Emoji (https://github.com/twitter/twemoji) with GWT.

Basic Usage
-----------
```java
Twemoji twemoji = new Twemoji();
twemoji.init(); // init the wrapper
String stringWithReplacedEmojis = twemoji.parse(strinWithUnicodes);
```