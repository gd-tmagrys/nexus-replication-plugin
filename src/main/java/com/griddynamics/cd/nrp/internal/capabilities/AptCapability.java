package com.griddynamics.cd.nrp.internal.capabilities;

import org.sonatype.nexus.capability.support.CapabilitySupport;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Map;

@Named( AptCapabilityDescriptor.TYPE_ID )
@Singleton
public class AptCapability
        extends CapabilitySupport
{
    private final AptSigningConfiguration signingConfiguration;

    private AptCapabilityConfiguration configuration;

    @Inject
    public AptCapability(AptSigningConfiguration signingConfiguration) {
        log.info("---------->AptSigningConfiguration");

        this.signingConfiguration = signingConfiguration;
    }

    @Override
    public void onCreate() throws Exception {
        configuration = createConfig(context().properties());
    }

    @Override
    public void onLoad() throws Exception {
        configuration = createConfig(context().properties());
    }

    @Override
    public void onUpdate() throws Exception {
        configuration = createConfig(context().properties());
    }

    @Override
    public void onRemove() throws Exception {
        configuration = null;
    }

    @Override
    public void onActivate() {
        signingConfiguration.setKeyring(configuration.getKeyring());
        signingConfiguration.setKey(configuration.getKey());
        signingConfiguration.setPassphrase(configuration.getPassphrase());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public AptCapabilityConfiguration createConfig(final Map properties) {
        return new AptCapabilityConfiguration( properties );
    }

//    @Override
//    protected Object createConfig(Map map) throws Exception {
//        return null;
//    }

}
