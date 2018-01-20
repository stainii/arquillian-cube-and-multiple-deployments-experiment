package be.stijnhooft.arquillian.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;

import java.io.File;


@RunWith(Arquillian.class)
public abstract class AbstractTest {


    @Deployment(name="test", testable = false)
    public static WebArchive create() {
        return ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addClass(FirstWebAppTest.class);
    }

    @Deployment(name="first-webapp-ear")
    public static EnterpriseArchive deployFirstWebApp() {
        File earFile = new File("target/dependency/first-webapp-ear-1.0.0-SNAPSHOT.ear");
        EnterpriseArchive archive = ShrinkWrap.createFromZipFile(EnterpriseArchive.class, earFile);
        return archive;
    }

    @Deployment(name="second-webapp-ear")
    public static EnterpriseArchive deploySecondWebApp() {
        File earFile = new File("target/dependency/second-webapp-ear-1.0.0-SNAPSHOT.ear");
        EnterpriseArchive archive = ShrinkWrap.createFromZipFile(EnterpriseArchive.class, earFile);
        return archive;
    }


}
