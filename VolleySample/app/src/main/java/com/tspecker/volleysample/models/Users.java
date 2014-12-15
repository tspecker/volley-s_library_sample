package com.tspecker.volleysample.models;

import com.tspecker.volleysample.models.interfaces.IUser;
import com.tspecker.volleysample.models.interfaces.IVolley;
import com.tspecker.volleysample.utilities.VolleyUtils;

import java.util.ArrayList;

import static com.tspecker.volleysample.utilities.Constants.WS_BASE_HTTP_URL;

/**
 * Created by tspecker on 09/12/14.
 *
 * @author tspecker
 * @version 1.0
 */
public class Users {

    public ArrayList<User> users;

    public class User {

        public String id;
        public String firstname;
        public String lastname;
        public String email;
        public String pwd;


        public void create(String aka, String email, String pwd, final IUser callback) {
            final String uriCreateUser = "/user";

            final String url = WS_BASE_HTTP_URL + uriCreateUser;

            ArrayList<ParamsRequest> paramsObj = new ArrayList<>();
            paramsObj.add(new ParamsRequest("email", email));
            paramsObj.add(new ParamsRequest("password", pwd));

            VolleyUtils.makePostStringRequest(url, paramsObj, new IVolley() {
                // TODO add treatment after receive response
            });
        }
    }
}
