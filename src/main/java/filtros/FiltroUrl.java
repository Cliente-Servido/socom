/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtros;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Wolverine20
 */
@WebFilter
public class FiltroUrl implements Filter{


    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        HttpSession session=req.getSession();
        System.out.println("paso por el filtro");
        
        String requestUrl=req.getRequestURL().toString();
        
        String[] urlPermitidaSinSesion=new String[]
        {
          
            "faces/Gerente/index.xhtml"
        };
        
        boolean redireccionarPeticion;
        
        if(session.getAttribute("usuario")==null)
        {            
            redireccionarPeticion=true;
            
            for(String item : urlPermitidaSinSesion)
            {
                if(requestUrl.contains(item))
                {
                    redireccionarPeticion=false;
                    
                    break;
                }
            }
        }
        else
        {
            redireccionarPeticion=false;
        }
        
        if(redireccionarPeticion)
        {
            res.sendRedirect(req.getContextPath()+"/faces/Gerente/index.xhtml");
        }
        else
        {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
       
    }
    
}
