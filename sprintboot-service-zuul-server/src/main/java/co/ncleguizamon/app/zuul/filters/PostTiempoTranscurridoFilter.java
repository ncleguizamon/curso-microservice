package co.ncleguizamon.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext(); 
		HttpServletRequest request = ctx.getRequest();
		
		log.info("Entrando al post");
		
		Long timeInit = (Long) request.getAttribute("timeInit");
		Long timeEnd = System.currentTimeMillis();
		long timeElapsed = timeEnd - timeInit;
		
		log.info(String.format("tiempo transcurrido en segundo %s seg", timeElapsed/1000 ));
		log.info(String.format("tiempo transcurrido en mileseg  %s ms", timeElapsed ));
		
		return null;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
