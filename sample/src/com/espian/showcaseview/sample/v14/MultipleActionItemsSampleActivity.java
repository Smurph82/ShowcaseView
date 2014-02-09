package com.espian.showcaseview.sample.v14;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActionBar.OnNavigationListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.espian.showcaseview.ShowcaseView;
import com.espian.showcaseview.ShowcaseViews;
import com.espian.showcaseview.ShowcaseViews.ItemViewProperties;
import com.espian.showcaseview.sample.R;

public class MultipleActionItemsSampleActivity extends Activity implements
		OnNavigationListener {

	public static final float SHOWCASE_SPINNER_SCALE = 1f;
	public static final float SHOWCASE_OVERFLOW_ITEM_SCALE = 0.5f;
	ShowcaseView.ConfigOptions mOptions = new ShowcaseView.ConfigOptions();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);
		ActionBar ab = getActionBar();
		ab.setDisplayHomeAsUpEnabled(true);
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		ab.setListNavigationCallbacks(new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, new String[] {
						"Item1", "Item2", "Item3" }), this);
		mOptions.block = false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);

		ShowcaseViews views = new ShowcaseViews(this,
				new ShowcaseViews.OnShowcaseAcknowledged() {
					@Override
					public void onShowCaseAcknowledged(ShowcaseView showcaseView) {
						Toast.makeText(getApplicationContext(),
								R.string.dismissed_message, Toast.LENGTH_SHORT)
								.show();
					}
				});
		ShowcaseView.ConfigOptions options = new ShowcaseView.ConfigOptions();
		options.shotType = ShowcaseView.TYPE_ONE_SHOT;
		options.showcaseId = 1234;
		views.addView(new ItemViewProperties(R.id.menu_item1,
				R.string.showcase_menu_item_one_shot_title,
				R.string.showcase_menu_item_one_shot_message,
				ShowcaseView.ITEM_SPINNER, SHOWCASE_SPINNER_SCALE, options));
		ShowcaseView.ConfigOptions configOptions = new ShowcaseView.ConfigOptions();
		configOptions.fadeInDuration = 700;
		configOptions.fadeOutDuration = 700;
		configOptions.block = true;
		views.addView(new ItemViewProperties(ItemViewProperties.ID_SPINNER,
				R.string.showcase_spinner_title,
				R.string.showcase_spinner_message, ShowcaseView.ITEM_SPINNER,
				SHOWCASE_SPINNER_SCALE, configOptions));
		views.addView(new ItemViewProperties(ItemViewProperties.ID_OVERFLOW,
				R.string.showcase_overflow_title,
				R.string.showcase_overflow_message,
				ShowcaseView.ITEM_ACTION_OVERFLOW, SHOWCASE_OVERFLOW_ITEM_SCALE));
		views.show();
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onNavigationItemSelected(int position, long id) {
		return false;
	}
}
