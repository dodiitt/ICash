package com.icash.controller;

import com.icash.provider.ProviderHandler;
import com.icash.provider_response.OfferToroResponse;
import com.icash.provider_response.PeanutLabsResponse;
import com.icash.provider_response.SampleCubeResponse;
import com.icash.provider_response.SuperRewardResponse;
import io.swagger.annotations.Api;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/public/provider/post-back")
@Api(value = "Callbacks controller", description = "This controller is used to called by 3th provider.")
public class PostbackController {

    private static final Log LOGGER = LogFactory.getLog(PostbackController.class);

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
    protected void processOfferToroPostBack(@RequestBody OfferToroResponse offerToroResponse){
        LOGGER.info("ICash received new callbacks from OfferToro for user : ");
        offerToroHandler.handle(offerToroResponse);
    }

    @RequestMapping(value = "/super-rewards", method = RequestMethod.GET)
    protected void processSuperRewardsPostBack(@RequestBody SuperRewardResponse superRewardResponse){
        LOGGER.info("ICash received new callbacks from SuperRewards for user : ");
        superRewardsHandler.handle(superRewardResponse);
    }

    @RequestMapping(value = "/peanut-labs", method = RequestMethod.GET)
    protected void processPeanutLabsPostBack(@RequestBody PeanutLabsResponse peanutLabsResponse){
        LOGGER.info("ICash received new callbacks from PeanutLabs for user : ");
        peanutLabsHandler.handle(peanutLabsResponse);
    }

    @RequestMapping(value = "/sample-cube", method = RequestMethod.GET)
    protected void processSampleCube(@RequestBody SampleCubeResponse sampleCubeResponse){
        LOGGER.info("ICash received new callbacks from SampleCube for user : ");
        sampleCubeHandler.handle(sampleCubeResponse);
    }
}
