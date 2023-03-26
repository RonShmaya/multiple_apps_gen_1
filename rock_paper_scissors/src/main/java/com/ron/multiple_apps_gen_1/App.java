package com.ron.multiple_apps_gen_1;

import com.ron.common.App_Parent;
import com.ron.common.utils.ServicesHelper;

public class App extends App_Parent {


    @Override
    public  void setGameActivity() {
        ServicesHelper.get_instance().setGame_activity(PapaerEtcGameActivity.class);
    }
}
