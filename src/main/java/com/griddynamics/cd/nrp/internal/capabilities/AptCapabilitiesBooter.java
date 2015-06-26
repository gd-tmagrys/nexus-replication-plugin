package com.griddynamics.cd.nrp.internal.capabilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonatype.nexus.plugins.capabilities.CapabilityRegistry;
import org.sonatype.nexus.plugins.capabilities.support.CapabilityBooterSupport;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class AptCapabilitiesBooter
        extends CapabilityBooterSupport
{

    private Logger log = LoggerFactory.getLogger(AptCapabilitiesBooter.class);

    @Inject
    public AptCapabilitiesBooter() {
        log.info("---------->AptCapabilitiesBooter");
    }

    @Override
    protected void boot( final CapabilityRegistry registry ) throws Exception {
        log.info("---------->AptCapabilitiesBooter.boot");
        maybeAddCapability(
                registry,
                AptCapabilityDescriptor.TYPE,
                true, // enabled
                null, // no notes
                new AptCapabilityConfiguration().asMap()
        );
    }

}
