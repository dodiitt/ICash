package com.icash.controller.user;

import com.icash.controller.response.EarningHistoriesResponse;
import com.icash.controller.response.NotificationResponse;
import com.icash.controller.response.RedeemHistoryResponse;
import com.icash.controller.response.UserInfoResponse;
import com.icash.entity.EarningHistory;
import com.icash.entity.Notification;
import com.icash.entity.RedeemHistory;
import com.icash.entity.User;
import com.icash.service.EarningHistoryService;
import com.icash.service.NotificationService;
import com.icash.service.RedeemHistoryService;
import com.icash.utils.UserUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/protected/api/v1/users")
@Api(value = "User controller", description = "It's used to get user info")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserUtils userUtils;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private EarningHistoryService earningHistoryService;

    @Autowired
    private RedeemHistoryService redeemHistoryService;

    /**
     * @return
     */

    @ApiOperation(value = "The User's general info.", response = UserInfoResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved user info"),
            @ApiResponse(code = 401, message = "You are not authenticated yet to access the resource"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 403, message = "User not active yet.")}
    )
    @RequestMapping(value = "/general-info", method = RequestMethod.GET)
    public ResponseEntity<?> getGeneralUserInfo() {
        User user = userUtils.currentUser();
        if (user == null) {
            throw new RuntimeException("Can not get User from security context holder.");
        }
        return ResponseEntity.ok(this.wrapGeneralUserInfo(user));
    }

    /**
     * @param page
     * @return
     */
    @ApiOperation(value = "The User's notification.", response = NotificationResponse.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved user's notification."),
            @ApiResponse(code = 401, message = "You are not authenticated yet to access the resource"),
            @ApiResponse(code = 403, message = "User not active yet."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")}
    )
    @RequestMapping(value = "/notification/{page}", method = RequestMethod.GET)
    public ResponseEntity<?> getNotification(@Min(value = 0) @NotNull @RequestParam Integer page) {
        User user = userUtils.currentUser();
        List<NotificationResponse> notificationResponse = extractNotifications(this.notificationService.getNotifications(user.getUserID(), page));
        return ResponseEntity.ok(notificationResponse);
    }


    /**
     * @param page
     * @return
     */
    @RequestMapping(value = "/history/earning/{page}", method = RequestMethod.GET)
    @ApiOperation(value = "The User's earning histories.", response = EarningHistoriesResponse.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved User's earning histories."),
            @ApiResponse(code = 401, message = "You are not authenticated yet to access the resource"),
            @ApiResponse(code = 403, message = "User not active yet."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")}
    )
    public ResponseEntity<?> getEarningHistories(@Min(value = 0) @NotNull @RequestParam Integer page) {
        User user = userUtils.currentUser();
        List<EarningHistoriesResponse> earningHistoriesResponses = extractEarningHistories(this.earningHistoryService.getEarningHistories(user.getUserID(), page));
        return ResponseEntity.ok(earningHistoriesResponses);
    }

    /**
     * @param page
     * @return
     */
    @RequestMapping(value = "/history/redeem/{page}", method = RequestMethod.GET)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved User's redeem histories"),
            @ApiResponse(code = 401, message = "You are not authenticated yet to access the resource"),
            @ApiResponse(code = 403, message = "User not active yet."),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")}
    )
    @ApiOperation(value = "The User's redeem histories.", response = RedeemHistoryResponse.class, responseContainer = "List")
    public ResponseEntity<?> getRedeemHistories(@Min(value = 0) @NotNull @RequestParam Integer page) {
        User user = userUtils.currentUser();
        List<RedeemHistoryResponse> redeemHistoryResponses = extractRedeemHistories(this.redeemHistoryService.getRedeemHistories(user.getUserID(), page));
        return ResponseEntity.ok(redeemHistoryResponses);
    }

    private List<RedeemHistoryResponse> extractRedeemHistories(Page<RedeemHistory> redeemHistories) {
        List<RedeemHistoryResponse> redeemHistoryResponses = new ArrayList<>();

        redeemHistories.forEach(v -> {
            RedeemHistoryResponse redeemHistoryResponse = new RedeemHistoryResponse();

            redeemHistoryResponse.setCashRedeem(v.getCashRedeem());
            redeemHistoryResponse.setiCoinsRedeem(v.getiCoinsRedeem());
            redeemHistoryResponse.setPaymentType(v.getPaymentType().name());
            redeemHistoryResponse.setTime(v.getTime());

            redeemHistoryResponses.add(redeemHistoryResponse);
        });
        return redeemHistoryResponses;
    }


    private List<EarningHistoriesResponse> extractEarningHistories(Page<EarningHistory> earningHistories) {
        List<EarningHistoriesResponse> earningHistoriesResponses = new ArrayList<>();
        earningHistories.getContent().forEach(v -> {
            EarningHistoriesResponse earningHistoriesResponse = new EarningHistoriesResponse();

            earningHistoriesResponse.setTitle(v.getEarningTitle());
            earningHistoriesResponse.setEarningType(v.getEarningType().name());
            earningHistoriesResponse.setiCoinsEarned(v.getiCoinsPaid());
            earningHistoriesResponse.setTime(v.getTime());

            earningHistoriesResponses.add(earningHistoriesResponse);
        });
        return earningHistoriesResponses;
    }

    private List<NotificationResponse> extractNotifications(Page<Notification> notifications) {
        List<NotificationResponse> notificationResponses = new ArrayList<>();
        notifications.getContent().forEach(v -> {
            NotificationResponse notificationResponse = new NotificationResponse();

            notificationResponse.setSubject(v.getSubject());
            notificationResponse.setMessage(v.getMessage());
            notificationResponse.setTime(v.getTime());

            notificationResponses.add(notificationResponse);
        });
        return notificationResponses;
    }

    private UserInfoResponse wrapGeneralUserInfo(User user) {
        UserInfoResponse userInfo = new UserInfoResponse();

        userInfo.setUsername(user.getUsername());
        userInfo.setiCoins(user.getCurrentICoins());
        userInfo.setAvatar(user.getAvatarImage());

        return userInfo;
    }
}
