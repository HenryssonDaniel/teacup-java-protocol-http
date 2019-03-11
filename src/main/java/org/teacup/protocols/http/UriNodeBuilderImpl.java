package org.teacup.protocols.http;

import static org.teacup.protocols.http.Constants.BUILD;
import static org.teacup.protocols.http.Constants.SETTING_THE;
import static org.teacup.protocols.http.Constants.SETTING_WHETHER;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class UriNodeBuilderImpl implements UriNodeBuilder {
  private static final Logger LOGGER = Logger.getLogger(UriNodeBuilderImpl.class.getName());
  private UriNodeSetter uriNodeSetter = new UriNodeImpl();

  @Override
  public UriNode build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "URI"));

    UriNode uriNode = uriNodeSetter;
    uriNodeSetter = new UriNodeImpl();

    return uriNode;
  }

  @Override
  public UriNodeBuilder setAbsolute(BooleanAssert absolute) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "absolute"));
    uriNodeSetter.setAbsolute(absolute);
    return this;
  }

  @Override
  public UriNodeBuilder setAssertion(ObjectAssert<URI, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    uriNodeSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public UriNodeBuilder setAuthority(StringAssert authority) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "authority"));
    uriNodeSetter.setAuthority(authority);
    return this;
  }

  @Override
  public UriNodeBuilder setFragment(StringAssert fragment) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "fragment"));
    uriNodeSetter.setFragment(fragment);
    return this;
  }

  @Override
  public UriNodeBuilder setHost(StringAssert host) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "host"));
    uriNodeSetter.setHost(host);
    return this;
  }

  @Override
  public UriNodeBuilder setOpaque(BooleanAssert opaque) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "opaque"));
    uriNodeSetter.setOpaque(opaque);
    return this;
  }

  @Override
  public UriNodeBuilder setPath(StringAssert path) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "path"));
    uriNodeSetter.setPath(path);
    return this;
  }

  @Override
  public UriNodeBuilder setPort(IntegerAssert port) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "port"));
    uriNodeSetter.setPort(port);
    return this;
  }

  @Override
  public UriNodeBuilder setQuery(StringAssert query) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "query"));
    uriNodeSetter.setQuery(query);
    return this;
  }

  @Override
  public UriNodeBuilder setRawAuthority(StringAssert rawAuthority) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw authority"));
    uriNodeSetter.setRawAuthority(rawAuthority);
    return this;
  }

  @Override
  public UriNodeBuilder setRawFragment(StringAssert rawFragment) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw fragment"));
    uriNodeSetter.setRawFragment(rawFragment);
    return this;
  }

  @Override
  public UriNodeBuilder setRawPath(StringAssert rawPath) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw path"));
    uriNodeSetter.setRawPath(rawPath);
    return this;
  }

  @Override
  public UriNodeBuilder setRawQuery(StringAssert rawQuery) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw query"));
    uriNodeSetter.setRawQuery(rawQuery);
    return this;
  }

  @Override
  public UriNodeBuilder setRawSchemeSpecificPart(StringAssert rawSchemeSpecificPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw scheme specific part"));
    uriNodeSetter.setRawSchemeSpecificPart(rawSchemeSpecificPart);
    return this;
  }

  @Override
  public UriNodeBuilder setRawUserInfo(StringAssert rawUserInfo) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw user info"));
    uriNodeSetter.setRawUserInfo(rawUserInfo);
    return this;
  }

  @Override
  public UriNodeBuilder setScheme(StringAssert scheme) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "scheme"));
    uriNodeSetter.setScheme(scheme);
    return this;
  }

  @Override
  public UriNodeBuilder setSchemeSpecificPart(StringAssert schemeSpecificPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "scheme specific part"));
    uriNodeSetter.setSchemeSpecificPart(schemeSpecificPart);
    return this;
  }

  @Override
  public UriNodeBuilder setUserInfo(StringAssert userInfo) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "user info"));
    uriNodeSetter.setUserInfo(userInfo);
    return this;
  }
}
