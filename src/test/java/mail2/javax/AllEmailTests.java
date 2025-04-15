package mail2.javax;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(EmailUnitTest.class)
public class AllEmailTests {}