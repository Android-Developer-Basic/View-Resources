package otus.gpb.homework.viewandresources

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Filter
import androidx.annotation.ArrayRes
import androidx.annotation.LayoutRes

class FArrayAdapter<T>(
    context: Context?, textViewResourceId: Int,
    objects: List<T>
) : ArrayAdapter<T>(context!!, textViewResourceId, objects) {
    private var filter: Filter = NoFilter()
    var items: List<T> = objects
    override fun getFilter(): Filter {
        return filter
    }
    fun setFiltering(on: Boolean) {
        filter= if (on) super.getFilter() else NoFilter()
    }

    private inner class NoFilter : Filter() {
        override fun performFiltering(arg0: CharSequence): FilterResults {
            val result = FilterResults()
            result.values = items
            result.count = items.size
            return result
        }

        override fun publishResults(arg0: CharSequence, arg1: FilterResults) {
            notifyDataSetChanged()
        }
    }

    companion object {
        fun createFromResource(
            context: Context,
            @ArrayRes textArrayResId: Int, @LayoutRes textViewResId: Int
        ): FArrayAdapter<CharSequence?> {
            val strings = context.resources.getTextArray(textArrayResId)
            return FArrayAdapter(context, textViewResId, listOf(*strings))
        }
    }
}