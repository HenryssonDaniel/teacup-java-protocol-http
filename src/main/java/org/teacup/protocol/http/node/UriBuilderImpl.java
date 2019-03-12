package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.SETTING_WHETHER;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.StringAssert;

class UriBuilderImpl extends BuilderImpl<URI, Uri, UriSetter, UriBuilder> implements UriBuilder {
  private static final Logger LOGGER = Logger.getLogger(UriBuilderImpl.class.getName());

  UriBuilderImpl() {
    super(new UriImpl());
  }

  @Override
  public UriBuilder setAbsolute(BooleanAssert absolute) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "absolute"));
    getSetter().setAbsolute(absolute);
    return this;
  }

  @Override
  public UriBuilder setAuthority(StringAssert authority) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "authority"));
    getSetter().setAuthority(authority);
    return this;
  }

  @Override
  public UriBuilder setFragment(StringAssert fragment) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "fragment"));
    getSetter().setFragment(fragment);
    return this;
  }

  @Override
  public UriBuilder setHost(StringAssert host) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "host"));
    getSetter().setHost(host);
    return this;
  }

  @Override
  public UriBuilder setOpaque(BooleanAssert opaque) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "opaque"));
    getSetter().setOpaque(opaque);
    return this;
  }

  @Override
  public UriBuilder setPath(StringAssert path) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "path"));
    getSetter().setPath(path);
    return this;
  }

  @Override
  public UriBuilder setPort(IntegerAssert port) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "port"));
    getSetter().setPort(port);
    return this;
  }

  @Override
  public UriBuilder setQuery(StringAssert query) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "query"));
    getSetter().setQuery(query);
    return this;
  }

  @Override
  public UriBuilder setRawAuthority(StringAssert rawAuthority) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw authority"));
    getSetter().setRawAuthority(rawAuthority);
    return this;
  }

  @Override
  public UriBuilder setRawFragment(StringAssert rawFragment) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw fragment"));
    getSetter().setRawFragment(rawFragment);
    return this;
  }

  @Override
  public UriBuilder setRawPath(StringAssert rawPath) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw path"));
    getSetter().setRawPath(rawPath);
    return this;
  }

  @Override
  public UriBuilder setRawQuery(StringAssert rawQuery) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw query"));
    getSetter().setRawQuery(rawQuery);
    return this;
  }

  @Override
  public UriBuilder setRawSchemeSpecificPart(StringAssert rawSchemeSpecificPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw scheme specific part"));
    getSetter().setRawSchemeSpecificPart(rawSchemeSpecificPart);
    return this;
  }

  @Override
  public UriBuilder setRawUserInfo(StringAssert rawUserInfo) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw user info"));
    getSetter().setRawUserInfo(rawUserInfo);
    return this;
  }

  @Override
  public UriBuilder setScheme(StringAssert scheme) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "scheme"));
    getSetter().setScheme(scheme);
    return this;
  }

  @Override
  public UriBuilder setSchemeSpecificPart(StringAssert schemeSpecificPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "scheme specific part"));
    getSetter().setSchemeSpecificPart(schemeSpecificPart);
    return this;
  }

  @Override
  public UriBuilder setUserInfo(StringAssert userInfo) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "user info"));
    getSetter().setUserInfo(userInfo);
    return this;
  }

  @Override
  protected UriSetter createSetter() {
    return new UriImpl();
  }
}
