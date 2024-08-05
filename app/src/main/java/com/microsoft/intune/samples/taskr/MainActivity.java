/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License.
 */

package com.microsoft.intune.samples.taskr;

import static java.lang.Class.forName;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationView;

import com.microsoft.identity.client.AuthenticationCallback;
import com.microsoft.identity.client.IAccount;
import com.microsoft.identity.client.IAuthenticationResult;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.exception.MsalIntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.client.exception.MsalUserCancelException;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.policy.MAMEnrollmentManager;
import com.microsoft.intune.samples.taskr.authentication.AppAccount;
import com.microsoft.intune.samples.taskr.authentication.AppSettings;
import com.microsoft.intune.samples.taskr.authentication.MSALUtil;
import com.microsoft.intune.samples.taskr.fragments.AboutFragment;
import com.microsoft.intune.samples.taskr.fragments.TasksFragment;
import com.microsoft.intune.samples.taskr.fragments.SubmitFragment;
import com.microsoft.intune.samples.taskr.trustedroots.ui.TrustedRootsFragment;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The main activity of the app - runs when the app starts.
 *
 * Handles authentication, explicitly interacting with MSAL and implicitly with MAM.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displaySignInView();

    }

    private void displaySignInView() {
        setContentView(R.layout.sign_in);
    }

    public void onClickSignIn(final View view) {

        //calling the activity from the module added via dynamic feature module here
        Class sdkActivity = null;
        try {
            sdkActivity = forName("com.adobe.scansdk.SampleDFActivity");
        } catch (ClassNotFoundException e) {
            Toast.makeText(this, "Activity not found", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, sdkActivity);
        startActivity(intent);

    }
}
