package com.griddynamics.cd.nrp.internal.capabilities;

import org.sonatype.nexus.capability.support.CapabilityDescriptorSupport;
import org.sonatype.nexus.formfields.FormField;
import org.sonatype.nexus.formfields.StringTextFormField;
import org.sonatype.nexus.plugins.capabilities.CapabilityDescriptor;
import org.sonatype.nexus.plugins.capabilities.CapabilityType;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import static org.sonatype.nexus.plugins.capabilities.CapabilityType.capabilityType;

@Singleton
@Named( AptCapabilityDescriptor.TYPE_ID )
public class AptCapabilityDescriptor
        extends CapabilityDescriptorSupport
        implements CapabilityDescriptor
{

    public static final String TYPE_ID = "apt";

    public static final CapabilityType TYPE = capabilityType( TYPE_ID );

    @Inject
    public AptCapabilityDescriptor() {
        super();
        log.info("---------->AptCapabilityDescriptor");
    }

    @Override
    public CapabilityType type() {
        return TYPE;
    }

    @Override
    public String name() {
        return "APT plugin configuration.";
    }

    @Override
    public List<FormField> formFields() {
        List<FormField> retVal = new ArrayList<>(3);

        retVal.add(new StringTextFormField(
                AptCapabilityConfiguration.KEYRING,
                "Secure keyring location",
                "The location of the GNU PG secure keyring to be used for signing",
                FormField.OPTIONAL
        ));

        retVal.add(new StringTextFormField(
                AptCapabilityConfiguration.KEY,
                "Key ID",
                "ID of the key in the secure keyring to be used for signing",
                FormField.MANDATORY
        ));

        retVal.add(new StringTextFormField(
                AptCapabilityConfiguration.PASSPHRASE,
                "Passphrase for the key",
                "Passphrase for the key to be used for signing",
                FormField.MANDATORY
        ));

        return retVal;
    }

}
