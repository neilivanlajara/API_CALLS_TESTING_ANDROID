package com.example.api_calls_testing_android.department_list;

import android.util.Log;

import com.example.api_calls_testing_android.model.DepartmentInfo;
import com.example.api_calls_testing_android.repository.GetWholeDepartmentListReadyRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class WholeDepartmentListModel {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<DepartmentInfo> ITEMS = new ArrayList<DepartmentInfo>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, DepartmentInfo> ITEM_MAP = new HashMap<String, DepartmentInfo>();

    private static final int COUNT = 25;

    private static void feedDepList(){
        GetWholeDepartmentListReadyRepository.getWholeDepartmentReady(
                wholeDepartmentList -> {
                    for (DepartmentInfo i :wholeDepartmentList.getDepartmentInfos() ) {
                        addItem(i);
                    }
                },
                ()->{
                    Log.d("errore", "feedDepList: ");
                }
        );
    }
    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPlaceholderItem(i));
        }
    }

    private static void addItem(DepartmentInfo item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getDisplayName(), item);
    }

    private static DepartmentInfo createPlaceholderItem(int position) {
        return new DepartmentInfo(ITEMS.get(position).getDepartmentId(), ITEMS.get(position).getDisplayName());
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class PlaceholderItem {
        public final String id;
        public final String content;
        public final String details;

        public PlaceholderItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}