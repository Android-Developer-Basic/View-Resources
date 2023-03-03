package otus.gpb.homework.viewandresources

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.databinding.ActivityCartBinding


class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityCartBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = GridLayoutManager(this, 1)
        val dividerItemDecoration = VerticalSpaceItemDecoration(
            24
        )
        binding.recyclerView.addItemDecoration(dividerItemDecoration)
        binding.recyclerView.adapter = CartAdapter()
    }
}
class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int):
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State) {
        outRect.bottom = verticalSpaceHeight
    }

}