package com.griddynamics.cd.nrp.internal.capabilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration adapter for {@link AptCapability}.
 *
 * @since 3.0
 */
public class AptCapabilityConfiguration
{

    public static final String KEYRING = "keyring";

    public static final String KEY = "key";

    public static final String PASSPHRASE = "passphrase";

    private String keyring;

    private String key;

    private String passphrase;

    public AptCapabilityConfiguration()
    {
        this(null, null, null);
    }

    public AptCapabilityConfiguration(String keyring, String key, String passphrase) {
        this.keyring = keyring == null ? "" : keyring;
        this.key = key == null ? "" : key;
        this.passphrase = passphrase == null ? "" : passphrase;
    }

    public AptCapabilityConfiguration(final Map<String, String> properties ) {
        this(properties.get(KEYRING), properties.get(KEY), properties.get(PASSPHRASE));
    }

    public String getKeyring()
    {
        return keyring;
    }

    public void setKeyring(String keyring)
    {
        this.keyring = keyring;
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getPassphrase()
    {
        return passphrase;
    }

    public void setPassphrase(String passphrase)
    {
        this.passphrase = passphrase;
    }

    public Map<String, String> asMap()
    {
        Map<String, String> map = new HashMap<>();
        map.put(KEYRING, keyring);
        map.put(KEY, key);
        map.put(PASSPHRASE, passphrase);

        return map;
    }

}
