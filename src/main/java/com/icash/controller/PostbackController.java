package com.icash.controller;

import com.icash.provider.ProviderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/post-back/v1")
public class PostbackController {

    // TODO Things for consider : this controller is really important, our provider will call with many time, we need to make performance as faster as well
    // TODO We can use TaskExecutor, or AsyncWorker to make it better


    @Autowired
    @Qualifier("offerToroHandler")
    private ProviderHandler offerToroHandler;

    @Autowired
    @Qualifier("superRewardsHandler")
    private ProviderHandler superRewardsHandler;

    @Autowired
    @Qualifier("peanutLabsHandler")
    private ProviderHandler peanutLabsHandler;

    @Autowired
    @Qualifier("sampleCubeHandler")
    private ProviderHandler sampleCubeHandler;

    @RequestMapping(value = "/offer-toro", method = RequestMethod.GET)
    protected void processOfferToroPostBack(){
        offerToroHandler.handle(null);
    }

    @RequestMapping(value = "/super-rewards", method = RequestMethod.GET)
    protected void processSuperRewardsPostBack(){
        superRewardsHandler.handle(null);
    }

    @RequestMapping(value = "/peanut-labs", method = RequestMethod.GET)
    protected void processPeanutLabsPostBack(){
        peanutLabsHandler.handle(null);
    }

    @RequestMapping(value = "/sample-cube", method = RequestMethod.GET)
    protected void processSampleCube(){
        sampleCubeHandler.handle(null);
    }
}
