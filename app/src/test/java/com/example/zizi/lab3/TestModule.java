package com.example.zizi.lab3;

import android.content.Context;

import com.example.zizi.lab3.ui.details.DetailsPresenter;
import com.example.zizi.lab3.ui.editor.EditorPresenter;
import com.example.zizi.lab3.ui.main.MainPresenter;
import com.example.zizi.lab3.ui.UIModule;
import com.example.zizi.lab3.utils.UiExecutor;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

@Module
public class TestModule {

	private final UIModule UIModule;

	public TestModule(Context context) {
		this.UIModule = new UIModule(context);
	}

	@Provides
	public Context provideContext() {
		return UIModule.provideContext();
	}


	@Provides
	public MainPresenter provideMainPresenter() {
		return UIModule.provideMainPresenter();
	}


    @Provides
    public DetailsPresenter provideDetailsPresenter() {
        return UIModule.provideDetailsPresenter();
    }


    @Provides
    public EditorPresenter provideEditorPresenter() {
        return UIModule.provideEditorPresenter();
    }


	@Provides
	@Singleton
	public EventBus provideEventBus() {
		return EventBus.getDefault();
	}

	@Provides
	@Singleton
	public Executor provideNetworkExecutor() {
		return new UiExecutor();
	}


}
