package jp.cayhanecamel.chai.widget;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jp.cayhanecamel.chai.base.AbstractMenuItemView;
import jp.cayhanecamel.chai.feature.main.ItemDto;
import jp.cayhanecamel.chai.R;

public class ListItemView extends AbstractMenuItemView {


    private TextView title;
    private TextView value;
    private View divider;

    public ListItemView(Context context) {
        super(context);
        inflate(getContext(), R.layout.jp_cayhanecamel_chai_list_item_app_info, this);
        title = (TextView) findViewById(R.id.jp_cayhanecamel_chai_title);
        value = (TextView) findViewById(R.id.jp_cayhanecamel_chai_value);
        divider = (View) findViewById(R.id.jp_cayhanecamel_chai_divider);

    }


    public void bind(ItemDto itemDto) {
        title.setText(itemDto.title);
        value.setText(itemDto.value);
        ViewGroup.LayoutParams layoutParams = divider.getLayoutParams();
        if (itemDto.type == ItemDto.Type.ContentEnd) {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.jp_cayhanecamel_chai_divider_end);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.jp_cayhanecamel_chai_divider);
        }

        if (TextUtils.isEmpty(title.getText())) {
            title.setVisibility(View.GONE);
        }
        // For on click
        setTag(R.id.jp_cayhanecamel_chai_tag_item, itemDto);
    }

    public void setCompoundDrawableRight(Drawable drawable) {
        value.setCompoundDrawables(null, null, drawable, null);
    }
}
