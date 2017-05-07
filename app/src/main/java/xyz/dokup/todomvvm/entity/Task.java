package xyz.dokup.todomvvm.entity;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

/**
 * Created by e10dokup on 2017/05/06.
 */
@Table
public class Task {

    @PrimaryKey(autoincrement = true)
    public int id;

    @Column
    public String title;

    @Column
    public String description;

    @Column
    public long deadlineEpoch;

    public Task() {
    }

    public Task(String title, String description, long deadlineEpoch) {
        this.title = title;
        this.description = description;
        this.deadlineEpoch = deadlineEpoch;
    }
}
