# DasFilm
DasFilm is a Android Paging library sample app that shows the current movies in theater using the Movie database API.
Moreover this DasFilm holds an example of:

     * Android Architecture Components (ViewModel and LiveData)
     * Rest API calls using Retrofit libray 
     * Building Android Costum Views 
     * Facebook shimmer Library 

# Android Paging library
The paging library makes it easier for your app to gradually load information as needed from a data source, without overloading the device or waiting too long for a big database query.
Many apps work with large sets of data, but only need to load and display a small portion of that data at any time. An app might have thousands of items that it could potentially display, but it might only need access to a few dozen of them at once. If the app isn't careful, it can end up requesting data it doesn't actually need, placing a performance burden on the device and the network. If the data is stored or synchronized with a remote database, this can also slow the app and waste the user's data plan.

## How it works ?
Together, the components of the Paging Library organize a data flow from a background thread producer, and presentation on the UI thread. For example, when a new item is inserted in your database, the DataSource is invalidated, and the LiveData<PagedList> or Flowable<PagedList> produces a new PagedList on a background thread.
  
  
That newly-created PagedList is sent to the PagedListAdapter on the UI thread. The PagedListAdapter then uses DiffUtil on a background thread to compute the difference between the current list and the new list. When the comparison is finished, the PagedListAdapter uses the list difference information to make appropriate call to RecyclerView.Adapter.notifyItemInserted() to signal that a new item was inserted.
The RecyclerView on the UI thread then knows that it only has to bind a single new item, and animate it appearing on screen.

One of the best talks that can introduce you to this new awsome library is the one of [Florina Muntenescu](https://medium.com/@florina.muntenescu) at GDDEurop 2017...[link to the video](https://www.youtube.com/watch?v=Ts-uxYiBEQ8)

