package com.endava.myendava.di.FragmentsDi;

import com.endava.myendava.fragments.FilteredTagsFragment;
import com.endava.myendava.fragments.TagsFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {TagsModule.class})
public interface TagsComponent {

    void inject(TagsFragment fragment);

    void inject(FilteredTagsFragment fragment);

    @Subcomponent.Builder
    interface Builder {
        TagsComponent.Builder tagsBuilder(TagsModule module);

        TagsComponent build();
    }
}