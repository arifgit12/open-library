package br.com.opengti.library.config.filter;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import org.apache.wicket.protocol.http.IWebApplicationFactory;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.protocol.http.WicketFilter;

/**
 * Filtro do Wicket para o Google Guice que permite a f&aacute;brica da instancia&ccedil;&atilde;o de um webapp do Wicket.
 * @author Rodrigo Mibielli.
 *
 */
@Singleton
@Log4j
public class WicketGuiceFilter extends WicketFilter
{
    private final Provider<WebApplication> appsProvider;

    @Inject
    public WicketGuiceFilter(Provider<WebApplication> appsProvider)
    {
        this.appsProvider = appsProvider;
    }
    
    @Override
    protected IWebApplicationFactory getApplicationFactory()
    {
        return new IWebApplicationFactory()
        {
            public WebApplication createApplication(WicketFilter filter)
            {
                return appsProvider.get();
            }
        };
    }
}