package com.example.tuprak5;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class PostFragment extends Fragment {

    private Uri selectedImageUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Menemukan elemen UI
        ImageView iv_home = view.findViewById(R.id.IV_Home);
        ImageView iv_search = view.findViewById(R.id.IV_Search);
        ImageView iv_profile = view.findViewById(R.id.IV_Profile);
        ImageView iv_foto = view.findViewById(R.id.iv_gambar);
        EditText ET_konten = view.findViewById(R.id.et_konten);
        Button btn_posting = view.findViewById(R.id.btn_posting);

        // Mendaftarkan ActivityResultLauncher untuk membuka galeri
        ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            selectedImageUri = data.getData();
                            if (selectedImageUri != null) {
                                iv_foto.setImageURI(selectedImageUri);
                            }
                        }
                    }
                }
        );

        // Mengatur klik listener untuk membuka galeri
        iv_foto.setOnClickListener(v -> {
            Intent openGallery = new Intent(Intent.ACTION_PICK);
            openGallery.setType("image/*");
            launcherIntentGallery.launch(openGallery);
        });

        // Mengatur klik listener untuk posting
        btn_posting.setOnClickListener(btn -> {
            String konten = ET_konten.getText().toString();

            if (konten.isEmpty()) {
                Toast.makeText(getActivity(), "Isi konten terlebih dahulu", Toast.LENGTH_SHORT).show();
            } else if (selectedImageUri != null) {
                // Membuat objek Data (dulu Instagram)
                Data data = new Data("qwesaddqwdq", "qweqwe", konten, R.drawable.ic_launcher_background, selectedImageUri);

                // Membuat bundle untuk menyimpan data
                Bundle bundle = new Bundle();
                bundle.putParcelable(HomeFragment.EXTRA_DATA, data);

                // Mengatur bundle ke HomeFragment
                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(bundle);

                // Mengganti fragmen dan menambahkan ke back stack
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.frame_container, homeFragment)
                        .addToBackStack(null)
                        .commit();
            } else {
                Toast.makeText(getActivity(), "Pilih gambar terlebih dahulu", Toast.LENGTH_SHORT).show();
            }
        });

        // Mengatur klik listener untuk tombol-tombol navigasi
        iv_home.setOnClickListener(v -> {
            HomeFragment homeFragment = new HomeFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, homeFragment)
                    .addToBackStack(null)
                    .commit();
        });

        iv_search.setOnClickListener(v -> {
            SearchFragment searchFragment = new SearchFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, searchFragment)
                    .addToBackStack(null)
                    .commit();
        });

        iv_profile.setOnClickListener(v -> {
            ProfileFragment profileFragment = new ProfileFragment();
            FragmentManager fragmentManager = getParentFragmentManager();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container, profileFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }
}
