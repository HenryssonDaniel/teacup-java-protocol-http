package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.BUILD;
import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.SETTING_WHETHER;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class UriBuilderImpl implements UriBuilder {
  private static final Logger LOGGER = Logger.getLogger(UriBuilderImpl.class.getName());
  private UriSetter uriSetter = new UriImpl();

  @Override
  public Uri build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "URI"));

    Uri uri = uriSetter;
    uriSetter = new UriImpl();

    return uri;
  }

  @Override
  public UriBuilder setAbsolute(BooleanAssert absolute) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "absolute"));
    uriSetter.setAbsolute(absolute);
    return this;
  }

  @Override
  public UriBuilder setAssertion(ObjectAssert<URI, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    uriSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public UriBuilder setAuthority(StringAssert authority) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "authority"));
    uriSetter.setAuthority(authority);
    return this;
  }

  @Override
  public UriBuilder setFragment(StringAssert fragment) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "fragment"));
    uriSetter.setFragment(fragment);
    return this;
  }

  @Override
  public UriBuilder setHost(StringAssert host) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "host"));
    uriSetter.setHost(host);
    return this;
  }

  @Override
  public UriBuilder setOpaque(BooleanAssert opaque) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "opaque"));
    uriSetter.setOpaque(opaque);
    return this;
  }

  @Override
  public UriBuilder setPath(StringAssert path) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "path"));
    uriSetter.setPath(path);
    return this;
  }

  @Override
  public UriBuilder setPort(IntegerAssert port) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "port"));
    uriSetter.setPort(port);
    return this;
  }

  @Override
  public UriBuilder setQuery(StringAssert query) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "query"));
    uriSetter.setQuery(query);
    return this;
  }

  @Override
  public UriBuilder setRawAuthority(StringAssert rawAuthority) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw authority"));
    uriSetter.setRawAuthority(rawAuthority);
    return this;
  }

  @Override
  public UriBuilder setRawFragment(StringAssert rawFragment) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw fragment"));
    uriSetter.setRawFragment(rawFragment);
    return this;
  }

  @Override
  public UriBuilder setRawPath(StringAssert rawPath) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw path"));
    uriSetter.setRawPath(rawPath);
    return this;
  }

  @Override
  public UriBuilder setRawQuery(StringAssert rawQuery) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw query"));
    uriSetter.setRawQuery(rawQuery);
    return this;
  }

  @Override
  public UriBuilder setRawSchemeSpecificPart(StringAssert rawSchemeSpecificPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw scheme specific part"));
    uriSetter.setRawSchemeSpecificPart(rawSchemeSpecificPart);
    return this;
  }

  @Override
  public UriBuilder setRawUserInfo(StringAssert rawUserInfo) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw user info"));
    uriSetter.setRawUserInfo(rawUserInfo);
    return this;
  }

  @Override
  public UriBuilder setScheme(StringAssert scheme) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "scheme"));
    uriSetter.setScheme(scheme);
    return this;
  }

  @Override
  public UriBuilder setSchemeSpecificPart(StringAssert schemeSpecificPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "scheme specific part"));
    uriSetter.setSchemeSpecificPart(schemeSpecificPart);
    return this;
  }

  @Override
  public UriBuilder setUserInfo(StringAssert userInfo) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "user info"));
    uriSetter.setUserInfo(userInfo);
    return this;
  }
}
