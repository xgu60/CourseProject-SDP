package edu.gatech.seclass.gobowl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import edu.gatech.seclass.gobowl.activities.*;

public class Screens {
    public static void ShowAddNewCustomerActivity(Context pContext)
    {
        Intent intent = new Intent(pContext, AddNewCustomerActivity.class);
        pContext.startActivity(intent);
    }

    public static void ShowBillActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, BillActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowBillAmountVerificationActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, BillAmountVerificationActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowScanCardsToViewScores(Context pContext) {
        Intent intent = new Intent(pContext,ScanCardsToViewScores.class);
        pContext.startActivity(intent);
    }
    public static void ShowCustomerActivity(Context pContext)
    {
        Intent intent = new Intent(pContext, CustomerActivity.class);
        pContext.startActivity(intent);
    }

    public static void ShowCustomerActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, CustomerActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void showRequestLaneScanCodeForRegisterActivity(Context pContext) {
        Intent intent = new Intent(pContext, RequestLaneScanCodeForRegisterActivity.class);
        pContext.startActivity(intent);
    }

    public static void ShowCustomerAddedActivity(Context pContext)
    {
        Intent intent = new Intent(pContext, CustomerAddedActivity.class);
        pContext.startActivity(intent);
    }

    public static void ShowCustomerAddedActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, CustomerAddedActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowCustomerCardPrintConfirmationActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, CustomerCardPrintConfirmationActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowCustomerInfoPromptActivity(Context pContext)
    {
        Intent intent = new Intent(pContext, CustomerInfoPromptActivity.class);
        pContext.startActivity(intent);
    }

    public static void ShowCustomerInfoPromptActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, CustomerInfoPromptActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowEditCustomerActivity(Context pContext)
    {
        Intent intent = new Intent(pContext, EditCustomerActivity.class);
        pContext.startActivity(intent);
    }

    public static void ShowEditCustomerActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, EditCustomerActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowEnterIndividualScoreActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, EnterIndividualScoreActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowEnterScoresListActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, EnterScoresListActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowLaneAssignedActivity(Context pContext)
    {
        Intent intent = new Intent(pContext, LaneAssignedActivity.class);
        pContext.startActivity(intent);
    }

    public static void ShowLaneAssignedActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, LaneAssignedActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowLaneCheckoutActivity(Context pContext)
    {
        Intent intent = new Intent(pContext, LaneCheckoutActivity.class);
        pContext.startActivity(intent);
    }

    public static void ShowLaneCheckoutSaveScoresPromptActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, LaneCheckoutSaveScoresPromptActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowMainActivity(Context pContext)
    {
        Intent intent = new Intent(pContext, MainActivity.class);
        pContext.startActivity(intent);
    }

    public static void ShowManagerActivity(Context pContext)
    {
        Intent intent = new Intent(pContext, ManagerActivity.class);
        pContext.startActivity(intent);
    }

    public static void ShowPrintCustomerCardActivity(Context pContext)
    {
        Intent intent = new Intent(pContext, PrintCustomerCardActivity.class);
        pContext.startActivity(intent);
    }

    public static void ShowPrintCustomerCardActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, PrintCustomerCardActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowScanCustomerCardActivity(Context pContext)
    {
        Intent intent = new Intent(pContext, ScanCustomerCardActivity.class);
        pContext.startActivity(intent);
    }

    public static void ShowScanCustomerCardActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, ScanCustomerCardActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowSwipeCreditCardActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, SwipeCreditCardActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowThanksActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, ThanksActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowViewScoresActivity(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, ViewScoresActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

    public static void ShowMessage(Context pContext, Bundle extras)
    {
        Intent intent = new Intent(pContext, MessageActivity.class);
        intent.putExtras(extras);
        pContext.startActivity(intent);
    }

//    public static void ShowMessage(Context pContext, String title, String message, Class<?> nextActivity)
//    {
//        Intent intent = new Intent(pContext, MessageActivity.class);
//
//        Bundle extras = new Bundle();
//        extras.putString("title", title);
//        extras.putString("message", message);
//        extras.putSerializable("nextActivity", nextActivity);
//        intent.putExtras(extras);
//        Log.d("What!!!!!!!!", "ShowMessage: !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        pContext.startActivity(intent);
//    }
}
