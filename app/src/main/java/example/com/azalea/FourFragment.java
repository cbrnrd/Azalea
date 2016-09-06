package example.com.azalea;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewSwitcher;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FourFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FourFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FourFragment extends Fragment {
    MapView mMapView;
    private GoogleMap googleMap;

    public FourFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_map_view, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); //needed to get the map to display immediately

        try{
            MapsInitializer.initialize(getActivity().getApplicationContext());
        }catch(Exception e){
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                //for showing a move to my location button
                try {
                    googleMap.setMyLocationEnabled(true);
                }catch(SecurityException se){} //figure out security exceptions and `checkPermission`

                //****Latitude and Longitude markers are make and dropped here****
                LatLng PACLatLng = new LatLng(38.993492, -77.127302);
                googleMap.addMarker(new MarkerOptions().position(PACLatLng).title("PAC Auditorium"));

                LatLng bearStore = new LatLng(38.993150, -77.126514);
                googleMap.addMarker(new MarkerOptions().position(bearStore).title("Bear Store")); //TODO ask for name of store during festival

                LatLng foodArea = new LatLng(38.993262, -77.125916);
                googleMap.addMarker(new MarkerOptions().position(foodArea).title("Food/Dining area"));

                LatLng shoppingArea = new LatLng(38.991232, -77.126806);
                googleMap.addMarker(new MarkerOptions().position(shoppingArea).title("Shopping/Art Sale"));

                LatLng ridesArea = new LatLng(38.992470, -77.126827);
                googleMap.addMarker(new MarkerOptions().position(ridesArea).title("Rides and Food"));
                //****************************************************************

                //for zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(PACLatLng).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                cameraPosition = new CameraPosition.Builder().target(bearStore).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition((cameraPosition)));
                cameraPosition = new CameraPosition.Builder().target(foodArea).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition((cameraPosition)));
                cameraPosition = new CameraPosition.Builder().target(shoppingArea).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition((cameraPosition)));
                cameraPosition = new CameraPosition.Builder().target(ridesArea).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition((cameraPosition)));
                //this may work idk yet
            }
        });
        return rootView;
    }
}
