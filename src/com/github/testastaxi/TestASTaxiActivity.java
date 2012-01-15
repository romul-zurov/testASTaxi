package com.github.testastaxi;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TestASTaxiActivity extends Activity implements LocationListener {

	private EditText		txtDist		= null, txtStart = null, txtStop = null;
	private LocationManager	locManager	= null;
	private Location		startLocation	= null, stopLocation = null;

	/* This method is called when use position will get changed */
	public void onLocationChanged(Location location) {
	}

	public void onProviderDisabled(String provider) {
	}

	public void onProviderEnabled(String provider) {
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		txtDist = (EditText) findViewById(R.id.edtxtDistance);
		txtStart = (EditText) findViewById(R.id.edtxtStartLocation);
		txtStop = (EditText) findViewById(R.id.edtxtStopLocation);
		locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 1.0f, this);
	}

	public void startStopClick(View view) {
		switch (view.getId()) {
			case R.id.button_start:
				startLocation = getAndShowLocation(txtStart);
				break;
			case R.id.button_stop:
				stopLocation = getAndShowLocation(txtStop);
				showDistance(startLocation, stopLocation, txtDist);
		}
	}

	private void showDistance(Location loc1, Location loc2, EditText edtxt) {
		if ((loc1 != null) && (loc2 != null)) {
			String dist = "Расстояние: " + loc1.distanceTo(loc2) + "м";
			edtxt.setText(dist);
		}
	}

	private void showLocation(Location location, EditText edtxt) {
		if (location != null) {
			double lat = location.getLatitude();
			double lng = location.getLongitude();
			String currentLocation = lng + " , " + lat;
			edtxt.setText(currentLocation);
		}
	}

	private Location getLocation() {
		Location location = new Location(LocationManager.GPS_PROVIDER);
		location = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		return location;
	}

	private Location getAndShowLocation(EditText edtxt) {
		Location location = getLocation();
		showLocation(location, edtxt);
		return location;
	}
}