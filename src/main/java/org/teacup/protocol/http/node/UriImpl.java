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

  private ObjectAssert<Boolean, ?> absolute;
  private ObjectAssert<String, ?> authority;
  private ObjectAssert<String, ?> fragment;
  private ObjectAssert<String, ?> host;
  private ObjectAssert<Boolean, ?> opaque;
  private ObjectAssert<String, ?> path;
  private ObjectAssert<Integer, ?> port;
  private ObjectAssert<String, ?> query;
  private ObjectAssert<String, ?> rawAuthority;
  private ObjectAssert<String, ?> rawFragment;
  private ObjectAssert<String, ?> rawPath;
  private ObjectAssert<String, ?> rawQuery;
  private ObjectAssert<String, ?> rawSchemeSpecificPart;
  private ObjectAssert<String, ?> rawUserInfo;
  private ObjectAssert<String, ?> scheme;
  private ObjectAssert<String, ?> schemeSpecificPart;
  private ObjectAssert<String, ?> userInfo;

  @Override
  public void setAbsolute(BooleanAssert<?> absolute) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "absolute"));
    this.absolute = absolute;
  }

  @Override
  public void setAuthority(StringAssert<?> authority) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "authority"));
    this.authority = authority;
  }

  @Override
  public void setFragment(StringAssert<?> fragment) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "fragment"));
    this.fragment = fragment;
  }

  @Override
  public void setHost(StringAssert<?> host) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "host"));
    this.host = host;
  }

  @Override
  public void setOpaque(BooleanAssert<?> opaque) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "opaque"));
    this.opaque = opaque;
  }

  @Override
  public void setPath(StringAssert<?> path) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "path"));
    this.path = path;
  }

  @Override
  public void setPort(IntegerAssert<?> port) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "path"));
    this.port = port;
  }

  @Override
  public void setQuery(StringAssert<?> query) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "query"));
    this.query = query;
  }

  @Override
  public void setRawAuthority(StringAssert<?> rawAuthority) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw authority"));
    this.rawAuthority = rawAuthority;
  }

  @Override
  public void setRawFragment(StringAssert<?> rawFragment) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw fragment"));
    this.rawFragment = rawFragment;
  }

  @Override
  public void setRawPath(StringAssert<?> rawPath) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw path"));
    this.rawPath = rawPath;
  }

  @Override
  public void setRawQuery(StringAssert<?> rawQuery) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw query"));
    this.rawQuery = rawQuery;
  }

  @Override
  public void setRawSchemeSpecificPart(StringAssert<?> rawSchemeSpecificPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw scheme specific part"));
    this.rawSchemeSpecificPart = rawSchemeSpecificPart;
  }

  @Override
  public void setRawUserInfo(StringAssert<?> rawUserInfo) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw user info"));
    this.rawUserInfo = rawUserInfo;
  }

  @Override
  public void setScheme(StringAssert<?> scheme) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "scheme"));
    this.scheme = scheme;
  }

  @Override
  public void setSchemeSpecificPart(StringAssert<?> schemeSpecificPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "scheme specific part"));
    this.schemeSpecificPart = schemeSpecificPart;
  }

  @Override
  public void setUserInfo(StringAssert<?> userInfo) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "user info"));
    this.userInfo = userInfo;
  }

  @Override
  public void verify(URI uri) {
    LOGGER.log(Level.FINE, String.format(VERIFY, "URI"));

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

  private static void verifyAssertion(ObjectAssert<? super URI, ?> objectAssert, URI uri) {
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
