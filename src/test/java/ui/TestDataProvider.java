package ui;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {

        return new Object[][]{

                {"standard_user", "wrong_password"},
                {"wrong_user", "secret_sauce"},
                {"wrong_user", "wrong_password"}
        };
    }


        @DataProvider(name = "loginData")
        public Object[][] loginData() {

            return new Object[][]{

                    {"standard_user", "secret_sauce"},
                    {"problem_user", "secret_sauce"},
                    {"performance_glitch_user", "secret_sauce"}
            };
        }
    }
