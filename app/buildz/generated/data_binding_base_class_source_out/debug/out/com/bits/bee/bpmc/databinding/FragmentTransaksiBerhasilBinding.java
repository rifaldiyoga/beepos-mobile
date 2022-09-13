// Generated by view binder compiler. Do not edit!
package com.bits.bee.bpmc.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bits.bee.bpmc.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentTransaksiBerhasilBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnTutup;

  @NonNull
  public final Button button7;

  @NonNull
  public final ImageView imageView8;

  @NonNull
  public final TextView textView43;

  @NonNull
  public final TextView tvKembali;

  private FragmentTransaksiBerhasilBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btnTutup, @NonNull Button button7, @NonNull ImageView imageView8,
      @NonNull TextView textView43, @NonNull TextView tvKembali) {
    this.rootView = rootView;
    this.btnTutup = btnTutup;
    this.button7 = button7;
    this.imageView8 = imageView8;
    this.textView43 = textView43;
    this.tvKembali = tvKembali;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentTransaksiBerhasilBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentTransaksiBerhasilBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_transaksi_berhasil, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentTransaksiBerhasilBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnTutup;
      Button btnTutup = ViewBindings.findChildViewById(rootView, id);
      if (btnTutup == null) {
        break missingId;
      }

      id = R.id.button7;
      Button button7 = ViewBindings.findChildViewById(rootView, id);
      if (button7 == null) {
        break missingId;
      }

      id = R.id.imageView8;
      ImageView imageView8 = ViewBindings.findChildViewById(rootView, id);
      if (imageView8 == null) {
        break missingId;
      }

      id = R.id.textView43;
      TextView textView43 = ViewBindings.findChildViewById(rootView, id);
      if (textView43 == null) {
        break missingId;
      }

      id = R.id.tvKembali;
      TextView tvKembali = ViewBindings.findChildViewById(rootView, id);
      if (tvKembali == null) {
        break missingId;
      }

      return new FragmentTransaksiBerhasilBinding((ConstraintLayout) rootView, btnTutup, button7,
          imageView8, textView43, tvKembali);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}