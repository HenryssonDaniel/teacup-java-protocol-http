package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.SETTING_WHETHER;
import static org.teacup.protocol.http.node.Constants.VERIFY;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class UriImpl extends SetterImpl<URI> implements UriSetter {
  private static final Logger LOGGER = Logger.getLogger(UriImpl.class.getName());

  private ObjectAssert<Boolean, BooleanAssert> absolute;
  private ObjectAssert<String, StringAssert> authority;
  private ObjectAssert<String, StringAssert> fragment;
  private ObjectAssert<String, StringAssert> host;
  private ObjectAssert<Boolean, BooleanAssert> opaque;
  private ObjectAssert<String, StringAssert> path;
  private ObjectAssert<Integer, IntegerAssert> port;
  private ObjectAssert<String, StringAssert> query;
  private ObjectAssert<String, StringAssert> rawAuthority;
  private ObjectAssert<String, StringAssert> rawFragment;
  private ObjectAssert<String, StringAssert> rawPath;
  private ObjectAssert<String, StringAssert> rawQuery;
  private ObjectAssert<String, StringAssert> rawSchemeSpecificPart;
  private ObjectAssert<String, StringAssert> rawUserInfo;
  private ObjectAssert<String, StringAssert> scheme;
  private ObjectAssert<String, StringAssert> schemeSpecificPart;
  private ObjectAssert<String, StringAssert> userInfo;

  @Override
  public void setAbsolute(BooleanAssert absolute) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "absolute"));
    this.absolute = absolute;
  }

  @Override
  public void setAuthority(StringAssert authority) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "authority"));
    this.authority = authority;
  }

  @Override
  public void setFragment(StringAssert fragment) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "fragment"));
    this.fragment = fragment;
  }

  @Override
  public void setHost(StringAssert host) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "host"));
    this.host = host;
  }

  @Override
  public void setOpaque(BooleanAssert opaque) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "opaque"));
    this.opaque = opaque;
  }

  @Override
  public void setPath(StringAssert path) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "path"));
    this.path = path;
  }

  @Override
  public void setPort(IntegerAssert port) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "path"));
    this.port = port;
  }

  @Override
  public void setQuery(StringAssert query) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "query"));
    this.query = query;
  }

  @Override
  public void setRawAuthority(StringAssert rawAuthority) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw authority"));
    this.rawAuthority = rawAuthority;
  }

  @Override
  public void setRawFragment(StringAssert rawFragment) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw fragment"));
    this.rawFragment = rawFragment;
  }

  @Override
  public void setRawPath(StringAssert rawPath) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw path"));
    this.rawPath = rawPath;
  }

  @Override
  public void setRawQuery(StringAssert rawQuery) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw query"));
    this.rawQuery = rawQuery;
  }

  @Override
  public void setRawSchemeSpecificPart(StringAssert rawSchemeSpecificPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw scheme specific part"));
    this.rawSchemeSpecificPart = rawSchemeSpecificPart;
  }

  @Override
  public void setRawUserInfo(StringAssert rawUserInfo) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw user info"));
    this.rawUserInfo = rawUserInfo;
  }

  @Override
  public void setScheme(StringAssert scheme) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "scheme"));
    this.scheme = scheme;
  }

  @Override
  public void setSchemeSpecificPart(StringAssert schemeSpecificPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "scheme specific part"));
    this.schemeSpecificPart = schemeSpecificPart;
  }

  @Override
  public void setUserInfo(StringAssert userInfo) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "user info"));
    this.userInfo = userInfo;
  }

  @Override
  public void verify(URI uri) {
    LOGGER.log(Level.FINE, String.format(VERIFY, "URI"));

    verifyAssertion(getAssertion(), uri);
    verifyBoolean(absolute, uri.isAbsolute());
    verifyString(authority, uri.getAuthority());
    verifyString(fragment, uri.getFragment());
    verifyString(host, uri.getHost());
    verifyBoolean(opaque, uri.isOpaque());
    verifyString(path, uri.getPath());
    verifyInteger(port, uri.getPort());
    verifyString(query, uri.getQuery());
    verifyString(rawAuthority, uri.getRawAuthority());
    verifyString(rawFragment, uri.getRawFragment());
    verifyString(rawPath, uri.getRawPath());
    verifyString(rawQuery, uri.getRawQuery());
    verifyString(rawSchemeSpecificPart, uri.getRawSchemeSpecificPart());
    verifyString(rawUserInfo, uri.getRawUserInfo());
    verifyString(scheme, uri.getScheme());
    verifyString(schemeSpecificPart, uri.getSchemeSpecificPart());
    verifyString(userInfo, uri.getUserInfo());
  }

  private static void verifyAssertion(ObjectAssert<? super URI, ?> objectAssert, URI uri) {
    if (objectAssert != null) objectAssert.verify(uri);
  }

  private static void verifyBoolean(
      ObjectAssert<? super Boolean, BooleanAssert> objectAssert, boolean actual) {
    if (objectAssert != null) objectAssert.verify(actual);
  }

  private static void verifyInteger(
      ObjectAssert<? super Integer, IntegerAssert> integerAssert, int actual) {
    if (integerAssert != null) integerAssert.verify(actual);
  }

  private static void verifyString(
      ObjectAssert<? super String, StringAssert> objectAssert, String actual) {
    if (objectAssert != null) objectAssert.verify(actual);
  }
}
