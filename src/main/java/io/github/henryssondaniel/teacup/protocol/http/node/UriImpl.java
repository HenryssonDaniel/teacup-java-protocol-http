package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

class UriImpl extends SetterImpl<URI, GenericObjectAssert<URI, ?>> implements UriSetter {
  private static final Logger LOGGER = Factory.getLogger(UriImpl.class);

  private GenericObjectAssert<Boolean, ?> absolute;
  private GenericObjectAssert<String, ?> authority;
  private GenericObjectAssert<String, ?> fragment;
  private GenericObjectAssert<String, ?> host;
  private GenericObjectAssert<Boolean, ?> opaque;
  private GenericObjectAssert<String, ?> path;
  private GenericObjectAssert<Integer, ?> port;
  private GenericObjectAssert<String, ?> query;
  private GenericObjectAssert<String, ?> rawAuthority;
  private GenericObjectAssert<String, ?> rawFragment;
  private GenericObjectAssert<String, ?> rawPath;
  private GenericObjectAssert<String, ?> rawQuery;
  private GenericObjectAssert<String, ?> rawSchemeSpecificPart;
  private GenericObjectAssert<String, ?> rawUserInfo;
  private GenericObjectAssert<String, ?> scheme;
  private GenericObjectAssert<String, ?> schemeSpecificPart;
  private GenericObjectAssert<String, ?> userInfo;

  @Override
  public void setAbsolute(GenericBooleanAssert<?> absolute) {
    LOGGER.log(Level.FINE, Constants.SETTING_WHETHER, "absolute");
    this.absolute = absolute;
  }

  @Override
  public void setAuthority(GenericStringAssert<?> authority) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "authority");
    this.authority = authority;
  }

  @Override
  public void setFragment(GenericStringAssert<?> fragment) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "fragment");
    this.fragment = fragment;
  }

  @Override
  public void setHost(GenericStringAssert<?> host) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "host");
    this.host = host;
  }

  @Override
  public void setOpaque(GenericBooleanAssert<?> opaque) {
    LOGGER.log(Level.FINE, Constants.SETTING_WHETHER, "opaque");
    this.opaque = opaque;
  }

  @Override
  public void setPath(GenericStringAssert<?> path) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "path");
    this.path = path;
  }

  @Override
  public void setPort(GenericIntegerAssert<?> port) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "path");
    this.port = port;
  }

  @Override
  public void setQuery(GenericStringAssert<?> query) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "query");
    this.query = query;
  }

  @Override
  public void setRawAuthority(GenericStringAssert<?> rawAuthority) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "raw authority");
    this.rawAuthority = rawAuthority;
  }

  @Override
  public void setRawFragment(GenericStringAssert<?> rawFragment) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "raw fragment");
    this.rawFragment = rawFragment;
  }

  @Override
  public void setRawPath(GenericStringAssert<?> rawPath) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "raw path");
    this.rawPath = rawPath;
  }

  @Override
  public void setRawQuery(GenericStringAssert<?> rawQuery) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "raw query");
    this.rawQuery = rawQuery;
  }

  @Override
  public void setRawSchemeSpecificPart(GenericStringAssert<?> rawSchemeSpecificPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "raw scheme specific part");
    this.rawSchemeSpecificPart = rawSchemeSpecificPart;
  }

  @Override
  public void setRawUserInfo(GenericStringAssert<?> rawUserInfo) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "raw user info");
    this.rawUserInfo = rawUserInfo;
  }

  @Override
  public void setScheme(GenericStringAssert<?> scheme) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "scheme");
    this.scheme = scheme;
  }

  @Override
  public void setSchemeSpecificPart(GenericStringAssert<?> schemeSpecificPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "scheme specific part");
    this.schemeSpecificPart = schemeSpecificPart;
  }

  @Override
  public void setUserInfo(GenericStringAssert<?> userInfo) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "user info");
    this.userInfo = userInfo;
  }

  @Override
  public void verify(URI uri) {
    LOGGER.log(Level.FINE, Constants.VERIFY, "URI");

    verifyAssertion(getAssertion(), uri);
    verifyAbsolute(uri);
    verifyAuthority(uri);
    verifyFragment(uri);
    verifyHost(uri);
    verifyOpaque(uri);
    verifyPath(uri);
    verifyPort(uri);
    verifyQuery(uri);
    verifyRawAuthority(uri);
    verifyRawFragment(uri);
    verifyRawPath(uri);
    verifyRawQuery(uri);
    verifyRawSchemeSpecificPart(uri);
    verifyRawUserInfo(uri);
    verifyScheme(uri);
    verifySchemeSpecificPart(uri);
    verifyUserInfo(uri);
  }

  private void verifyAbsolute(URI uri) {
    if (absolute != null) absolute.verify(uri.isAbsolute());
  }

  private static void verifyAssertion(GenericObjectAssert<? super URI, ?> objectAssert, URI uri) {
    if (objectAssert != null) objectAssert.verify(uri);
  }

  private void verifyAuthority(URI uri) {
    if (authority != null) authority.verify(uri.getAuthority());
  }

  private void verifyFragment(URI uri) {
    if (fragment != null) fragment.verify(uri.getFragment());
  }

  private void verifyHost(URI uri) {
    if (host != null) host.verify(uri.getHost());
  }

  private void verifyOpaque(URI uri) {
    if (opaque != null) opaque.verify(uri.isOpaque());
  }

  private void verifyPath(URI uri) {
    if (path != null) path.verify(uri.getPath());
  }

  private void verifyPort(URI uri) {
    if (port != null) port.verify(uri.getPort());
  }

  private void verifyQuery(URI uri) {
    if (query != null) query.verify(uri.getQuery());
  }

  private void verifyRawAuthority(URI uri) {
    if (rawAuthority != null) rawAuthority.verify(uri.getRawAuthority());
  }

  private void verifyRawFragment(URI uri) {
    if (rawFragment != null) rawFragment.verify(uri.getRawFragment());
  }

  private void verifyRawPath(URI uri) {
    if (rawPath != null) rawPath.verify(uri.getRawPath());
  }

  private void verifyRawQuery(URI uri) {
    if (rawQuery != null) rawQuery.verify(uri.getRawQuery());
  }

  private void verifyRawSchemeSpecificPart(URI uri) {
    if (rawSchemeSpecificPart != null) rawSchemeSpecificPart.verify(uri.getRawSchemeSpecificPart());
  }

  private void verifyRawUserInfo(URI uri) {
    if (rawUserInfo != null) rawUserInfo.verify(uri.getRawUserInfo());
  }

  private void verifyScheme(URI uri) {
    if (scheme != null) scheme.verify(uri.getScheme());
  }

  private void verifySchemeSpecificPart(URI uri) {
    if (schemeSpecificPart != null) schemeSpecificPart.verify(uri.getSchemeSpecificPart());
  }

  private void verifyUserInfo(URI uri) {
    if (userInfo != null) userInfo.verify(uri.getUserInfo());
  }
}
