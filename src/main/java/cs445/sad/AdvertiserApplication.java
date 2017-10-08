/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs445.sad;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author sukrins
 */
public class AdvertiserApplication extends ResourceConfig {

    AdvertiserApplication(final AdvertiserDao dao) {
        packages("cs445.sad");
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(dao).to(AdvertiserDao.class);
            }
        });
    }
}
